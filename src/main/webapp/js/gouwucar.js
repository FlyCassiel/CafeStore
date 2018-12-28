$(document)
		.ready(
				function() {
					// 全局的checkbox选中和未选中的样式
					var $allCheckbox = $('input[type="checkbox"]'); // 全局的全部checkbox
					$wholeChexbox = $('.whole_check'); // 全选
					$sonCheckBox = $('.son_check'); // 每个商铺下的商品的checkbox

					$allCheckbox.click(function() {
						if ($(this).is(':checked')) {
							$(this).next('label').addClass('mark');
						} else {
							$(this).next('label').removeClass('mark')
						}
					});
					// ===============================================全局全选与单个商品的关系================================
					// 全选的时候单个按钮都被选中
					$wholeChexbox.click(function() {
						var $checkboxs = $(".cc")
								.find('input[type="checkbox"]');
						if ($(this).is(':checked')) {
							$checkboxs.prop("checked", true);
							$checkboxs.next('label').addClass('mark');
						} else {
							$checkboxs.prop("checked", false);
							$checkboxs.next('label').removeClass('mark');
						}
						totalMoney();
					});
					// 单个按钮和全选按钮的关系
					$sonCheckBox
							.each(function() {
								$(this)
										.click(
												function() {
													if ($(this).is(':checked')) {
														// 判断：所有单个商品是否勾选
														var len = $sonCheckBox.length;
														var num = 0;
														$sonCheckBox
																.each(function() {
																	if ($(this)
																			.is(
																					':checked')) {
																		num++;
																	}
																});
														if (num == len) {
															$wholeChexbox.prop(
																	"checked",
																	true);
															$wholeChexbox
																	.next(
																			'label')
																	.addClass(
																			'mark');
														}
													} else {
														// 单个商品取消勾选，全局全选取消勾选
														$wholeChexbox.prop(
																"checked",
																false);
														$wholeChexbox.next(
																'label')
																.removeClass(
																		'mark');
													}
													totalMoney();
												})

							});
					// =================================================商品数量==============================================
					// 加号的单击事件
					var $plus = $('.plus'), 
						$reduce = $('.reduce'), 
						$all_sum = $('.sum');
					$plus.click(function() {
						var $inputVal = $(this).prev('input'),
										$count = parseInt($inputVal.val()) + 1, 
										$obj = $(this).parents('.xian').find('.reduce'), 
										$priceTotalObj = $(this).parents('.cc').find('.sum_price'), 
										$price = $(this).parents('.cc').find('.price').html(), // 单价
										$priceTotal = $count * parseInt($price);
										$inputVal.val($count);
										$priceTotalObj.html($priceTotal);
										if ($inputVal.val() > 1
												&& $obj.hasClass('reSty')) {
											$obj.removeClass('reSty');
										}
								totalMoney();
								
								var id=$(this).parent().siblings('td').eq(0).attr('id');
								var count=$(this).prev().val();
								$.ajax({
									type: "GET",
									url:"../cart/updateCountById.do",
									data: {id:id,count:count},
									success: function(data){
									}
								});
								
							});
					// －按钮的点击事件
					$reduce
							.click(function() {
								var $inputVal = $(this).next('input'), $count = parseInt($inputVal
										.val()) - 1, $priceTotalObj = $(this)
										.parents('.cc').find('.sum_price'), $price = $(
										this).parents('.cc').find('.price')
										.html(), // 单价
								$priceTotal = $count * parseInt($price);
								if ($inputVal.val() > 1) {
									$inputVal.val($count);
									$priceTotalObj.html($priceTotal);
								}
								if ($inputVal.val() == 1
										&& !$(this).hasClass('reSty')) {
									$(this).addClass('reSty');
								}
								totalMoney();
								var id=$(this).parent().siblings('td').eq(0).attr('id');
								var count=$(this).next().val();
								$.ajax({
									type: "GET",
									url:"../cart/updateCountById.do",
									data: {id:id,count:count},
									success: function(data){
									}
								});
							});

					/* 不懂 */
					$all_sum.keyup(function() {
						var $count = 0, $priceTotalObj = $(this).parents('.cc')
								.find('.sum_price'), $price = $(this).parents(
								'.cc').find('.price').html(), // 单价
						$priceTotal = 0;
						if ($(this).val() == '') {
							$(this).val('1');
						}
						$(this).val($(this).val().replace(/\D|^0/g, ''));
						$count = $(this).val();
						$priceTotal = $count * parseInt($price.substring(1));
						$(this).attr('value', $count);
						$priceTotalObj.html('$priceTotal');
						totalMoney();
					})

					// ======================================移除商品========================================

					// ================================特点是移除的时候出现半遮层（卷帘效果）
					// 确定移除就是移除关闭回到原页面（淡出效果）
					// ========================================
					var $order_lists = null;
					var $order_content = '';
					$('.delete').click(
							function() {
								$order_lists = $(this).parents('.cc');
								var id = $(this).parent().siblings('td').eq(0)
										.children('.id').val();
								$('#model_id').val(id);
								$('.model_bg').slideDown(300);
								$('.my_model').slideDown(400);
								
								// 确定按钮，移除商品
								$('.dialog-sure').click(function() {
									var id = $("#model_id").val();
									$order_lists.remove();
									closeM();
									// 重新定义了一下按钮
									$sonCheckBox = $('.son_check');
									totalMoney();
									var url = '../cart/deleteById.do?id=' + id;
									window.location.href = url;
								})
							});
					// 关闭模态框
					// 定义一个关闭半遮层的函数
					function closeM() {
						$('.model_bg').fadeOut(300);
						$('.my_model').fadeOut(300);
					}
					// 关闭X的时候
					$('.closeModel').click(function() {
						// 调用关闭半遮层的函数
						closeM();
					});
					// 对话框点击关闭按钮的时候的事件
					$('.dialog-close').click(function() {
						// 调用关闭半遮层的函数
						closeM();
					});
					
					
					/* 批量删除   ???*/
					$('.foot_del').click(function() {
						$('.model_bg').slideDown(300);
						$('.my_model').slideDown(400);
						
						// 确定按钮，移除商品
						$('.dialog-sure').click(function() {
							var str = [];
							$sonCheckBox.each(function() {
								if($(this).is(':checked')){
									var id = $(this).parent().attr('id');
									str.push(id);
									$(this).parent().remove();
								}
							});
							closeM();
							// 重新定义了一下按钮
							$sonCheckBox = $('.son_check');
							totalMoney();
							var url = '../cart/deleteByBatch.do?ids=' + str;
							window.location.href = url;
						})
					});
					// ==================总计
					// ==========================================
					// ==================特点就是每个全选的按钮点击的时候就会出现相应的数
					// 没有勾选每个全选按钮的时候总计没有件数和价钱==========================================
					// totalMoney每次都会被定义
					function totalMoney() {
						var total_money = 0;
						var total_count = 0;
						var calBtn = $('.calBtn a');
						$sonCheckBox.each(function() {
							if ($(this).is(':checked')) {
								var goods = parseInt($(this).parents('.cc')
										.find('.sum_price').html());
								var num = parseInt($(this).parents('.cc').find(
										'.sum').val());
								total_money += goods;
								total_count += num;
							}

						});
						$('.total_text').html("￥" + total_money);
						$('.piece_num').html(total_count);
						// console.log(total_money,total_count);
						// ======================================去结算==========================================
						// ==================效果就是件数和钱数不为零的时候移除禁用的效果==========================================
						var str=[];//所选中的商品id数组
						if (total_money != 0 && total_count != 0) {
							if (!calBtn.hasClass('btn_sty')) {
								calBtn.addClass('btn_sty');
							}
						} else {
							if (calBtn.hasClass('btn_sty')) {
								calBtn.removeClass('btn_sty');
							}
						}
						//点击去结算
						$('.submit').click(function(){
							$sonCheckBox.each(function() {
								if($(this).is(':checked')){
									var id = $(this).parent().attr('id');
									str.push(id);
								}
							});
							console.log("总价钱="+total_money);
							console.log(str);
							//当选中才能去结算
							if(str.length>0){
								var url = '../order/showOrder.do?ids='+str;
								 window.location.href = url;
							}else{
								alert("请先选择商品，再去结算，谢谢！！！")
							}
						})
					}
				});
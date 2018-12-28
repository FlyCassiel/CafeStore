//管理收藏夹
$('.manage').click(function(){
    if($('.manage span').hasClass('normal')){
        $('.manage span').removeClass('normal').addClass('show');
        $('.manage span').html('取消管理');
        $('.check_top').show();
        $('.mask').show();
    }else{
        $('.manage span').removeClass('show').addClass('normal');
        $('.manage span').html('管理收藏夹');
        $('.check_top').hide();
        $('.mask').hide();
    }
})
//单选
$('.mask').click(function(){
    if($(this).children().hasClass('maskNormal')){
        $(this).children().addClass('maskTrue').removeClass('maskNormal');
        $(this).children().children().attr('src','../img/collect/product_true_big.png');
    }else{
        $(this).children().addClass('maskNormal').removeClass('maskTrue');
        $(this).children().children().attr('src','../img/collect/product_normal_big.png');
    }
})
//全选
$('.all').click(function(){
    if($('.all span').hasClass('normal')){
        $('.all>span').addClass('true').removeClass('normal');
        $('.all>span>img').attr('src','../img/collect/product_true.png');
        $(".mask>div").each(function() {
            $(this).addClass('maskTrue').removeClass('maskNormal');
            $(this).children('img').attr('src','../img/collect/product_true_big.png');
        })
    }else{
        $('.all>span').addClass('normal').removeClass('true');
        $('.all>span>img').attr('src','../img/collect/product_normal.png');
        $(".mask>div").each(function() {
            $(this).addClass('maskNormal').removeClass('maskTrue');
            $(this).children('img').attr('src', '../img/collect/product_normal_big.png');
        })
    }
})
//删除
$('.del').click(function(){
    var str=[];
    $('.mask>div').each(function(){
        if($(this).hasClass('maskTrue')){
            var id=$(this).parent().parent().attr('id');
            str.push(id);
        }
    });
    console.log(str);
    if(str.length>0){
        $('.modal').show();
        //删除宝贝
        $('.yes').click(function(){
             $.ajax({
                 type: "POST",
                 url: "../collect/deleteByBatch.do",
                 data: "goodsids="+str,
                 success: function(obj){
                	 if (obj.state == 1) {
                		 $('.modal').hide();
                 		alert(obj.message);
                 		window.location.href="../collect/showCollect.do";
         			}else{
         				$('.modal').hide();
         				alert(obj.message);
         			}
                 }
             });
        })
        $('.no').click(function(){
            $('.modal').hide();
        })
    }else{
        $('.modalNo').fadeIn();
        $('.close').click(function(){
            $('.modalNo').fadeOut();
        })
    }
})
//全部加入购物车
$('.allAdd').click(function(){
    var str=[];
    $('.mask>div').each(function(){
        if($(this).hasClass('maskTrue')){
            var id=$(this).parent().parent().attr('id');
            str.push(id);
        }
    });
    console.log(str);
    if(str.length>0){
    	$(".modalYi").show();
    	$('.yes').click(function(){
        	$.ajax({
                type: "POST",
                url: "../cart/addCartByBatch.do",
                data: "goodsids="+str+"&count=1",
                success: function(obj){
                	if (obj.state == 1) {
                		$('.modalYi').hide();
                		alert("加入购物车成功！");
                		 $('.mask>div').each(function(){
                		        if($(this).hasClass('maskTrue')){
                		        	$(this).parent().prev().children(".addCart").hide();
                		        	$(this).parent().prev().children(".succee").show();
                		        }
                		    });
                		window.location.href="../collect/showCollect.do";
        			}else{
        				$('.modalYi').hide();
        				alert("加入 购物车失败！");
        			}
                }
            });
        })
        $('.no').click(function(){
            $('.modalYi').hide();
        })
    }else{
        $('.modalAdd').fadeIn();
        $('.close').click(function(){
        $('.modalAdd').fadeOut();
        })
    }
})
//单独添加购物车
$('.addCart').click(function(){
	$(".modalYi").show();
    var id= $(this).parent().parent().attr('id');
    alert(id);
    $('.yes').click(function(){
    	$.ajax({
            type: "POST",
            url: "../cart/addCart.do",
            data: "goodsid="+id+"&count=1",
            success: function(obj){
            	if (obj.state == 1) {
            		$('.modalYi').hide();
            		alert("加入购物车成功！");
    			}else{
    				$('.modalYi').hide();
    				alert("加入 购物车失败！");
    			}
            }
        });
    })
    $('.no').click(function(){
        $('.modalYi').hide();
    })
    $(this).hide();
	$(this).next().show();
})


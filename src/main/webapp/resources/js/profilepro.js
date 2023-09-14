	let userNo=$('#add').attr("data-add-num");
	let pageNum=1;
	let tp=0;
		
	productsList(userNo,pageNum);

	
	function productsList(userNo,page){
		$.ajax({
			type:"get",
			url:"../profile/prolist",
			data:{
				userNo:userNo,
				page:page
			},
			success:function(result){
				$('#add').append(result);
				tp = $('#totalpage').attr('data-totalPage');
				let button='<button class="border "id="moreButton"><i class="bi bi-plus-circle-fill me-1" style="color:#CCCCCC;"></i>상품 더보기('+pageNum+'/'+tp+')</button>';
				
				$('#more').html(button);
			},error:function(){
				alert('관리자에게 문의');
			}
		})
		
			$('#more').on("click", "#moreButton", function(){
			
			if(pageNum>=tp){
				alert('마지막 페이지');
				return;
			}
			
			pageNum++;
			productsList(userNo,pageNum);
		
		})
	}
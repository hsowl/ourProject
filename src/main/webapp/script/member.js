function cartCheck(){
    var answer=confirm("장바구니를 이용하시겠습니까?")
    if(answer){
        window.location.href="main.jsp"
    }else{
        window.location.href="productDetail.jsp"
    }
}
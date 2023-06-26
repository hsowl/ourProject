function confirmSelection() {
    var response = confirm("장바구니로 가시겠습니까?");
    if (response) {
        window.location.href="myCart.jsp"
    } else {
        close();
    }
}
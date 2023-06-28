function checkAllNo(checkAllNo){
    const  checkboxes = document.getElementsByName('productNo');

    checkboxes.forEach((checkbox)=>{
        checkbox.checked = checkAllNo.checked;
})
}
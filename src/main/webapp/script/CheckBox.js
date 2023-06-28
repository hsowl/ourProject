function checkAllNo(checkAllNo){
    const  checkboxes = document.querySelectorAll('input[type="checkbox"]');

    checkboxes.forEach((checkbox)=>{
        checkbox.checked = checkAllNo.checked;
})
}
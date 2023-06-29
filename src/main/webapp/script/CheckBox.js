function selectAll(selectAll){
    const  checkboxes = document.getElementsByName('no');

    checkboxes.forEach((checkbox)=>{
        checkbox.checked = selectAll.checked;
})
}
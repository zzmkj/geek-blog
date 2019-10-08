var form_js = {
    form_add(a) {
        let formData = new FormData($(a).parents("form")[0]);
        api.form_add(formData).then(
            mes=>{
                alert("success");
            },
            err => {
                alert("error")
            }
        )
    }
}
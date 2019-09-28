$("button[data-category=submit]").click(function () {

    let formData = new FormData($("#category-form")[0]);

    api.category_add(formData).then(mes => {
        console.log("success");
        window.location.reload();
    }, err => {
        console.log("failure");
    });

});
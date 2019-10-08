var name;
var form_item = {
    add_click_name(a){
        name = $(a).val();
    },
    add_blur_name(a) {
        let name1 = $(a).val();
        let id = $(a).data("id");
        if (name1 == name) {
            console.log("重复了")
        }else{
            api.form_item_name(name1,id).then(
                mes => {
                    alert("修改成功");
                },
                err => {
                    alert("修改失败");
                }
            )
        }
    },
    add_type(a) {
        let type = $(a).val();
        let id = $(a).data("id");
        api.form_item_type(type, id).then(
            mes => {
                alert("修改成功");
            },
            err => {
                alert("修改失败");
            }
        );
    }
}
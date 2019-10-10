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
    },
    add_option(a){
        let last = $(a).parent().find("tr:last");
        let id = $(last).data("id");
        let upid=id+1;
        let html=`<tr id="option${upid}" data-id="${upid}">
                        <td>
                            <div class="sort-handler ui-sortable-handle">
                                <i class="fas fa-th"></i>
                            </div>
                        </td>

                        <td ><input type="text" class="form-control" name="option"></td>

                        <td>
                            <button type="button" onclick="form_item.delete_option(this);" class="btn btn-secondary">Delete</button>
                        </td>
                    </tr>`
        if (id == 0) {
            $("#option0").after(html);
        }else{
            $(`#option${id}`).after(html);
        }
    },
    delete_option(a){
        $(a).parent().parent().remove()
    },
    click_option(a){
        let id = $(a).data("id");
        let html=`<td hidden><input type="text" class="form-control" name="formItemid" value="${id}"></td>`
        $("#option0").after(html);
    }
}
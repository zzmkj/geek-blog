const ajax = function (url, type, data = {}, formdata = false,contentType, async = false) {
    if (type != "POST" && type != "GET") {
        data["_method"] = type;
    }
    let promise = new Promise(function (sucess_fun, error_fun) {
        $.ajax(new ajax_obj(url, type, data, formdata, contentType, async, sucess_fun, error_fun))
    });
    return promise;
}
const ajax_obj = function (url, type, data, formdata, contentType, async, sucess_fun, error_fun) {
    this.url = url;
    this.type = type;
    this.data = data;
    this.success = sucess_fun;
    this.error = error_fun;
    if (formdata) {
        this.processData = false;
        if (contentType != null && contentType != "") {
            this.contentType = contentType;
        } else {
            this.contentType = false;
        }
    }
    if (async) {
        this.async = false;
    }
}
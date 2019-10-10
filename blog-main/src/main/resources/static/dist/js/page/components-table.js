"use strict";

$("[data-checkboxes]").each(function() {
  var me = $(this),
    group = me.data('checkboxes'),
    role = me.data('checkbox-role');

  me.change(function() {
    var all = $('[data-checkboxes="' + group + '"]:not([data-checkbox-role="dad"])'),
      checked = $('[data-checkboxes="' + group + '"]:not([data-checkbox-role="dad"]):checked'),
      dad = $('[data-checkboxes="' + group + '"][data-checkbox-role="dad"]'),
      total = all.length,
      checked_length = checked.length;

    if(role == 'dad') {
      if(me.is(':checked')) {
        all.prop('checked', true);
      }else{
        all.prop('checked', false);
      }
    }else{
      if(checked_length >= total) {
        dad.prop('checked', true);
      }else{
        dad.prop('checked', false);
      }
    }
  });
});

var updown = function (e, ui) {
  let flag = 1;
  let item = ui.item.parent().children();
  let ids = item.find("td.ids");
  let idsarr = [];
  let sort = [];
  for (let i = 0 ; i < ids.length; i ++){
      let idsval = $(ids[i]).text();
      idsarr.push(idsval);
      sort.push(flag);
      flag++;
  }
    api.form_item_sort(idsarr.join(",")).then(
        mes => {
            alert("success");
        }
    );
};

$("#sortable-table tbody").sortable({
  handle: '.sort-handler',
    stop: updown
});
/*
$("#sortable-option tbody").sortable({
    handle: '.sort-handler'
});*/
$("#sortable-option tbody").sortable({
    handle: '.sort-handler'
});
$(function () {

    const appendTask = function (data) {
        var taskCode = '<a href="#" class="task-link" data-id="' +
            data.id + '">' + data.text + '</a>' +
            ' <button id="delete-task" data-id="' +
            data.id + '">Удалить задачу</button>';
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

    //Show adding book form
    $('#show-add-task-form').click(function () {
        $('#task-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#task-form').click(function (event) {
        if (event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting task
    $(document).on('click', '.task-link', function () {
        var link = $(this);
        var taskId = link.data('id');
            $.ajax({
                method: "GET", url: '/tasks/' + taskId,
                success: function (response) {
                    var code = '<br><span data-id="' + taskId + '">Время выполнения: ' + response.taskDate + '</span>';
                    link.parent().append(code);
                }, error: function (response) {
                    if (response.status == 404) {
                        alert('Задача не найдена!');
                    }
                }
            });
        return false;
    });

    //Adding task
    $('#save-task').click(function () {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "POST", url: '/tasks/', data: data, success: function (response) {
                $('#task-form').css('display', 'none');
                var task = {};
                task.id = response;
                var dataArray = $('#task-form form').serializeArray();
                for (i in dataArray) {
                    task[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTask(task);
                data.c;
            }
        });
        return false;
    });

    //Removing task
    $(document).on('click', '#delete-task', function () {
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
            method: "DELETE", url: '/tasks/' + taskId,
            success: function () {
                link.parent("div").remove();
            }, error: function () {
                alert("тут");
            }
        });
        return false;
    });
});
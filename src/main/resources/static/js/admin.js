var main = {
    init : function () {
        var _this = this;

        $('#btn-cancel').on('click', function (event) {
            location.href = "/" + event.target.value;
        });

        $('#btn-save').on('click', function (event) {
            _this.save(event.target.value);
        });

        $('#btn-update').on('click', function (event) {
            _this.update(event.target.value);
        });

        $('#btn-delete').on('click', function (event) {
            _this.delete(event.target.value);
        });
    },
    save : function (type) {
        switch (type) {
            case 'category':
                var data = {
                    categoryNameKr: $('#categoryNameKr').val(),
                    categoryNameEng: $('#categoryNameEng').val(),
                    categoryColor: $('#categoryColor').val(),
                    categoryState: 'Y'
                };
                break;

            case 'brand':
                var data = {
                    brandNameKr: $('#brandNameKr').val(),
                    brandNameEng: $('#brandNameEng').val(),
                    brandColor: $('#brandColor').val(),
                    brandIntroduction: $('#brandIntroduction').val(),
                    brandLink: $('#brandLink').val(),
                    brandState: 'Y'
                };
                break;

            case 'influencer':
                var data = {
                    influencerNameKr: $('#influencerNameKr').val(),
                    influencerNameEng: $('#influencerNameEng').val(),
                    influencerColor: $('#influencerColor').val(),
                    influencerIntroduction: $('#influencerIntroduction').val(),
                    influencerLink: $('#influencerLink').val(),
                    influencerState: 'Y'
                };
                break;

            case 'schedule':
                var data = {
                    scheduleRegisteredPerson: $('#scheduleRegisteredPerson').val(),
                    scheduleCategory: $('#scheduleCategory').val(),
                    scheduleBrand: $('#scheduleBrand').val(),
                    scheduleInfluencer: $('#scheduleInfluencer').val(),
                    scheduleStartDate: $('#scheduleStartDate').val(),
                    scheduleEndDate: $('#scheduleEndDate').val(),
                    scheduleState: 'Y'
                };
                break;
        }

        $.ajax({
            type: 'POST',
            url: '/api/admin/' + type,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href = '/' + type;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function (type) {
        switch (type) {
            case 'category':
                var data = {
                    categoryNameKr: $('#categoryNameKr').val(),
                    categoryNameEng: $('#categoryNameEng').val(),
                    categoryColor: $('#categoryColor').val(),
                    categoryState: 'Y'
                };
                break;

            case 'brand':
                var data = {
                    brandNameKr: $('#brandNameKr').val(),
                    brandNameEng: $('#brandNameEng').val(),
                    brandColor: $('#brandColor').val(),
                    brandIntroduction: $('#brandIntroduction').val(),
                    brandLink: $('#brandLink').val(),
                    brandState: 'Y'
                };
                break;

            case 'influencer':
                var data = {
                    influencerNameKr: $('#influencerNameKr').val(),
                    influencerNameEng: $('#influencerNameEng').val(),
                    influencerColor: $('#influencerColor').val(),
                    influencerIntroduction: $('#influencerIntroduction').val(),
                    influencerLink: $('#influencerLink').val(),
                    influencerState: 'Y'
                };
                break;

            case 'schedule':
                var data = {
                    scheduleRegisteredPerson: $('#scheduleRegisteredPerson').val(),
                    scheduleCategory: $('#scheduleCategory').val(),
                    scheduleBrand: $('#scheduleBrand').val(),
                    scheduleInfluencer: $('#scheduleInfluencer').val(),
                    scheduleStartDate: $('#scheduleStartDate').val(),
                    scheduleEndDate: $('#scheduleEndDate').val(),
                    scheduleState: 'Y'
                };
                break;
        }

        var id = $('#' + type + 'Code').val();

        $.ajax({
            type: 'PUT',
            url: '/api/admin/' + type + '/' +id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href = '/' + type;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function (type) {
        var id = $('#' + type + 'Code').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/admin/' + type + '/' +id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            window.location.href = '/' + type;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();
$(document).ready(function() {
        var rowsPerPage = 10;
        var rows = $('tbody tr');
        var rowsCount = rows.length;
        var pageCount = Math.ceil(rowsCount / rowsPerPage);

        for (var i = 0; i < pageCount; i++) {
            $('.pagination').append('<button class="page-link btn btn-outline-info">' + (i + 1) + '</button>');
        }

        rows.hide();
        rows.slice(0, rowsPerPage).show();

        $('.pagination button').first().addClass('active');

        $('.pagination button').on('click', function() {
            var pageNum = $(this).text();
            var start = (pageNum - 1) * rowsPerPage;
            var end = start + rowsPerPage;

            rows.hide();
            rows.slice(start, end).show();

            $('.pagination button').removeClass('active');
            $(this).addClass('active');
        });
});
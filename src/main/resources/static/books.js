$(document).ready(() => {
    let bookToEdit;

    $('#add-button-modal').click(() => {

        const name = $('#modal-name').val();
        const author = $('#modal-author').val();
        const type = $('#modal-type').val();
        const publisher = $('#modal-publisher').val();


        const newBook = {
            name: name,
            author: author,
            type: type,
            publisher: publisher,
        };

        if (bookToEdit == null) {
            addBook(newBook);
        } else {
            editBook(bookToEdit, newBook)
        }
    });

    function editBook(id, newBook) {
        fetch('api/books/' + id, {
            method: 'PUT',
            body: JSON.stringify(newBook),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    }

    function addBook(newBook) {
        fetch('api/books', {
            method: 'POST',
            body: JSON.stringify(newBook),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    }

    $('.edit-icon').click(function () {
        bookToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const name = row.children[0].innerText;
        const author = row.children[1].innerText;
        const type = row.children[2].innerText;
        const publisher = row.children[3].innerText;


        $('#modal-name').val(name);
        $('#modal-author').val(author);
        $('#modal-type').val(type);
        $('#modal-publisher').val(publisher);
    });

    $('.delete-icon').click(function () {
        const bookId = this.parentElement.id;

        fetch('api/books/' + bookId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });

    $('#add-book-button').click(function () {
        bookToEdit = null;
        clearModal();
    });

    function clearModal() {
        $('#modal-name').val('');
        $('#modal-author').val('');
        $('#modal-type').val('');
        $('#modal-publisher').val('');
    }
});
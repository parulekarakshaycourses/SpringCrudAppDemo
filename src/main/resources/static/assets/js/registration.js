$(document).ready(function()
{
    var regForm = $('#regForm');
    var btn = $('#btnRegister');

    regForm.on('submit', function(event)
    {
        if(regForm[0].checkValidity())
        {
            event.preventDefault();

            btn.val('Please Wait');
            btn.addClass('disabled')

            var endpoint = '/emp/save/';
            var data =
            {
                name : $('#name').val(),
                designation : $('#designation').val(),
                salary : $('#salary').val()
            }

            console.log('data = ' + data);
            console.log('data.toString() = ' + data.toString());

            axios.post(endpoint, data)
                .then(function(response) {
                    emp = response.data;
                    console.log('response : ' + emp.id + ', ' + emp.name + ', ' + emp.designation + ', ' + emp.salary);
                    swal('Success', 'Registration successful. You can Login now.', 'success')
                        .then((value) => {window.location.replace('/emp/reg/')});
                })
                .catch(function(error) {
                    console.log(error);
                    swal('Oops!', 'Registration Failed! Please try again later.', 'error');

                    btn.val('Save');
                    btn.removeClass('disabled')
                });

        }
    });
});
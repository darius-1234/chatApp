<script>
    import { getUserDetails } from '../hooks/auth';
    import { store } from '../hooks/auth';

    let username = '';
    let error = ''

    async function login() {
        const user = await getUserDetails( username )

        if ( user ) {
            console.log(user)
            $store = user
            if ( error ) error = ''
        }
        else {
            error = 'Incorrect username'
            console.log("Incorrect username")
        }

    }

</script>

<form on:submit|preventDefault={login} class="flex mx-auto col-6">

    <div class="mb-3">
        <input class="form-control" id="username" placeholder="Username" bind:value={username} />
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    <div id="error_message" class="text-danger">
        <small>{error}</small>
    </div>

</form>
<style>
    input {
        width: 300px;
        height: 40px;
        border: none;
        border-radius: 7px;
        background-color: rgba(0,0,0,0.7);
        color: white;
        font-size: 18px;
        padding-left: 10px;
    }
</style>

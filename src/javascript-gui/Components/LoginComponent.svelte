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
<main>
    <h1>Chat App</h1>
</main>
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
    main{
        text-align: center;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }
    h1 {
        color: #99003b;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 100;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }

    body {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        height: 100vh;
        font-family: "Trebuchet MS";

    }

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

    button {
        margin: 20px;
        width: 300px;
        height: 40px;
        border: none;
        border-radius: 7px;
        background-color: #000000;
        color: white;
        font-size: 18px;
        padding-left: 10px;
        cursor: pointer;
    }
</style>

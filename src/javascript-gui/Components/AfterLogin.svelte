<script>
    import { username } from '../hooks/auth';

    let line = '';
    let chat = 'user ' + username +' has joined the chat \n'

    async function message(info) {
        chat = chat + '\n' + info;
    }

</script>
<main>
    {chat}
</main>
<form on:submit|preventDefault={message(line)} class="flex mx-auto col-6">
    <div class="mb-4">
        <input class="form-control" id="message" placeholder="Enter message" bind:value={line} />
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

</form>
<style>
    main{

    }
    h1 {
        color: #99003b;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 100;
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
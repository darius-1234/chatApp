<script>
	import LoginComponent from './Components/LoginComponent.svelte';
	import { store } from './hooks/auth';
	import AfterLogin from './Components/AfterLogin.svelte';
</script>

<main>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--	<input type="text" class="Username" placeholder="Username">-->

<!--	<button>Login</button>-->
	{#if $store != null }
		<AfterLogin />
	{:else }
		<LoginComponent />
	{/if}
</main>

<style>
	main {
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


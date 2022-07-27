<script>
    import AfterLogin from 'Components/AfterLogin.svelte';
    import { store } from '../hooks/auth';
    import LoginComponent from '../Components/LoginComponent.svelte';
</script>

{#if $store != null }
    <AfterLogin />
{:else }
    <LoginComponent />
{/if}
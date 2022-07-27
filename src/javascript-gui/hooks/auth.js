import { writable } from 'svelte/store';

const user = 'yeah'

export const store = writable(null);

let sessions = []

export const getUserDetails = async ( username ) => {
    if ( username === user )
        return 1
}
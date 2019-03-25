import events from './utils/events/event-actions'
import api from './utils/api/api-actions'

import Songs from './components/Songs'
import Albums from './components/Albums'
import Artists from './components/Artists'

main()

function main() {
	api.getRequest('/artists', artists => {
		getAppContext().innerHTML = Artists(artists)
	})
	const albumButton = document.querySelector('.nav__albums');
	console.log(albumButton);
	navSongs()
	navAlbums()
	navArtists() 
}

function navArtists() {
	const artistButton = document.querySelector('.nav__artists');
	events.on(document.querySelector('.nav__artists'), 'click', ()=> {
		api.getRequest('/artists', artists => {
			getAppContext().innerHTML = Artists(artists)
		})
	})
}

function navAlbums() {
	const albumButton = document.querySelector('.nav__albums');
	events.on(albumButton, 'click', ()=> {
		api.getRequest('/albums', albums => {
			getAppContext().innerHTML = Albums(albums)
		})
	})
}

function navSongs() {
	const songButton = document.querySelector('.nav__songs');
	events.on(songButton, 'click', ()=> {
		api.getRequest('/songs', songs => {
			getAppContext().innerHTML = Songs(songs)
		})
	})
}

function getAppContext() {
	return document.querySelector('#app')
}





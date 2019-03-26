import events from './utils/events/event-actions'
import api from './utils/api/api-actions'

import Songs from './components/Songs'
import Albums from './components/Albums'
import Artists from './components/Artists'
import Artist from './components/Artist'

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
	addArtists()
	viewSingleArtist()
	addAlbumToArtist()
}




// All Nav functions will live here
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









//All artist functions will live here
function addArtists() {
	events.on(getAppContext(), 'click', ()=> {
		if(event.target.classList.contains('add__artist__button')) {
			const artistName = document.querySelector('.add__artistName').value
			const image = document.querySelector('.add__image').value
			api.postRequest('/artists/add', {
				artistName : artistName,
				image : image
			}, (artists) => getAppContext().innerHTML = Artists(artists))
		}
	})
}

function viewSingleArtist() {
	events.on(getAppContext(), 'click', () => {
		if(event.target.classList.contains('artist__artistName')) {
			api.getRequest(`/artists/${event.target.id}`, artist => {
				getAppContext().innerHTML = Artist(artist)
			})
		}
	})
}
//All Album functions will live here

function addAlbumToArtist(){
	events.on(getAppContext(), 'click', () =>{
		if(event.target.classList.contains('add__album__button')){
			const albumTitle = document.querySelector('.add__albumTitle').value
			const image = document.querySelector('.add__image').value
			api.postRequest(`/albums/${event.target.id}`, {
				albumTitle : albumTitle,
				image : image	
			}, (artist) => getAppContext().innerHTML = Artist(artist) )
		}
	})
}










function getAppContext() {
	return document.querySelector('#app')
}







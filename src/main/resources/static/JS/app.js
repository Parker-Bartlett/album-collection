import events from './utils/events/event-actions'
import api from './utils/api/api-actions'

import Songs from './components/Songs'
import Song from './components/Song'
import Albums from './components/Albums'
import Album from './components/Album'
import Artists from './components/Artists'
import Artist from './components/Artist'
import Genre from './components/Genre'

main()

function main() {
	api.getRequest('/artists', artists => {
		getAppContext().innerHTML = Artists(artists)
	})
	navSongs()
	navAlbums()
	navArtists() 
	addArtists()
	viewSingleArtist()
	addAlbumToArtist()
	viewSingleAlbum()
	addSongToAlbum()
	viewSingleSong()
	addCommentToSong()
	addGenreToArtist()
	addRatingToAlbum()
}




// All Nav functions will live here
function navArtists() {
	const artistButton = document.querySelector('.nav__artists');
	events.on(artistButton, 'click', ()=> {
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
			api.postRequest(`/albums/add/${event.target.id}`, {
				albumTitle : albumTitle,
				image : image	
			}, (artist) => getAppContext().innerHTML = Artist(artist) )
		}
	})
}

function viewSingleAlbum(){
	events.on(getAppContext(), 'click', () => {
		if(event.target.classList.contains('album__albumTitle')){
			api.getRequest(`/albums/${event.target.id}`, album => {
				getAppContext().innerHTML = Album(album)
			})
		}
	})
}

// All song functions will live here

function addSongToAlbum(){
	events.on(getAppContext(), 'click', () =>{
		if(event.target.classList.contains('add__song__button')){
			const songTitle = document.querySelector('.add__songTitle').value
			const duration = document.querySelector('.add__duration').value
			const link = document.querySelector('.add__link').value
			api.postRequest(`/songs/add/${event.target.id}`, {
				songTitle : songTitle,
				duration : duration,
				link : link
			}, (album) => getAppContext().innerHTML = Album(album))
		}
	})
}

function viewSingleSong() {
	events.on(getAppContext(), 'click', () => {
		if(event.target.classList.contains('song__songTitle')) {
			api.getRequest(`/songs/${event.target.id}`, song => {
				getAppContext().innerHTML = Song(song)
			})
		}
	})
}

// Comment functions here

function addCommentToSong() {
	events.on(getAppContext(), 'click', () => {
		if(event.target.classList.contains('add__comment__button')) {
			const commentContent = document.querySelector('.add__commentContent').value
			api.postRequest(`/comments/add/${event.target.id}`, {
				commentContent : commentContent
			}, (song) => getAppContext().innerHTML = Song(song))
		}
	})
}

//genre

function viewSingleGenre(){ 
    events.on(getAppContext(), 'click', () => {
        if(event.target.classList.contains('genre__genreName')){
            api.getRequest(`/genres/${event.target.id}`, genre => {
                getAppContext().innerHTML = Genre(genre)
            })
        }
    })
}

function addGenreToArtist() {
	events.on(getAppContext(), 'click', () => {
		if(event.target.classList.contains('add__genre__button')) {
			const genreName = document.querySelector('.add__genreName').value
			api.postRequest(`/genres/add/${event.target.id}`, {
				genreName: genreName
			}, (artist) => {
				getAppContext().innerHTML = Artist(artist)
			})
		}
	})
}

//ratings
function addRatingToAlbum() {
	events.on(getAppContext(), 'click', (event) => {
		if(event.target.classList.contains('add__rating__button')) {
			const rating = document.querySelector('.add__rating__value').value
			if (rating >= 1 && rating <= 5) {
				api.postRequest(`/ratings/add/${event.target.id}`, {
					rating: rating
				}, (album) => {
					getAppContext().innerHTML = Album(album)
				})
			}
		}
	})
}


function getAppContext() {
	return document.querySelector('#app')
}







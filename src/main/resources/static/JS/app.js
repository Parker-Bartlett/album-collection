import events from './utils/events/event-actions'
import api from './utils/api/api-actions'

import Songs from './components/Songs'
import Albums from './components/Albums'
import Artists from './components/Artists'

main()

function main() {
	api.getRequest('/songs', songs => {
		getAppContext().innerHTML = Songs(songs)
	})
	api.getRequest('/albums', albums => {
		getAppContext().innerHTML += Albums(albums)
	})
	api.getRequest('/artists', artists => {
		getAppContext().innerHTML += Artists(artists)
	})
}


function getAppContext() {
	return document.querySelector('#app')
}





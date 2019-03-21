fetch("/songs")
	.then(response => response.json())
	.then(songs => {
		let songSong = `<ul>`;
		songs.forEach(song => {
			songSong += `				
				<li>
					   <h3>${song.songTitle}</h3>
					   <ul>
						  
						   ${song.comments.map(comment => {
				  return `
								  <li>
									  <p>${comment.commentContent}</p>

								  </li>
							  `;
				})
				.join("")}
					   </ul>
				   </li>
			   `;
		});
		songSong += `</ul>`;
		app.innerHTML = songSong;
	})
	.catch(err => console.log(err));

buttonEventListener();
function buttonEventListener(){
	const albumsButton = document.querySelector('.albums-button')
	const artistsButton = document.querySelector('.artists-button')
	const songsButton = document.querySelector('.songs-button')

	albumsButton.addEventListener('click', retrieveAlbums);

	artistsButton.addEventListener('click', ()=> {
		retrieveArtists(artistsButton)
		
	})

	songsButton.addEventListener('click', ()=> {
		retrieveSongs(songsButton)
		
	})

	function retrieveAlbums(){
		fetch("/albums")
		.then(response => response.json())
		.then(albums => {
		let albumAlbum = `<ul>`;
		albums.forEach(album => {
			albumAlbum += `				
				<li>
					<h3>${album.albumTitle}</h3>
				</li>
			`;
		})
		albumAlbum += `</ul>`;
		app.innerHTML = albumAlbum;
	})
	.catch(err => console.log(err));
	}

	

}
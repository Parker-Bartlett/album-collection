const app = document.querySelector("#app");


fetch('/songs')
	.then(response => response.json())
	.then(songs => {
		let content = `<ul>`
		songs.forEach((song) => {
			content += `<li>${song.songTitle} ${song.duration} ${song.link}</li>`;
// 			<ul> ${songs.comments.map(songs => {return `
// 				<li> ${song.songTitle} </li> `;
// 				})
// 				}.join("")}
// 				</ul>
//     		songs[0].comments.forEach(comment => {
    		// commentsContent += `<li>${comment.content}</li>`
		})
		content += `</ul>`;
		app.innerHTML = content;
	})
	.catch(err => console.log(err));


	// fetch("/songs")
	// .then(response => response.json())
	// .then(songs => {
	//   let content = `<ul>`;
	//   songs.forEach(song => {
	// 	content += `
	// 			   <li>
	// 				   <h3>${song.songTitle}</h3>
	// 				   <ul>
	// 					   ${songs.comments
	// 			.map(comment => {
	// 			  return `
	// 							  <li class="book">
	// 								  <p class="book__description">${comment.content}</p>
	// 							  </li>
	// 						  `;
	// 			})
	// 			.join("")}
	// 				   </ul>
	// 			   </li>
	// 		   `;
	//   });
	//   content += `</ul>`;
	//   let commentsContent = '<ul>';
	//   authors[0].comments.forEach(comment => {
	// 	  commentsContent += `<li>${comment.content}</li>`
	//   })
	//   commentsContent += '</ul>'
	//   app.innerHTML = commentsContent;
	// })
	// .catch(err => console.log(err));
    


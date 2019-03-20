// const app = document.querySelector("#app");


// fetch('/songs')
// 	.then(response => response.json())
// 	.then(songs => {
// 		let content = `<ul>`
// 		songs.forEach((song) => {
// 			content += `<li>${song.songTitle} ${song.duration} ${song.link}</li>`;

// 			<ul> ${songs.comments.map(songs => {return `
// 				<li> ${song.songTitle} </li> `;
// 				})
// 				}.join("")}
// 				</ul>
//     		songs[0].comments.forEach(comment => {
    		// commentsContent += `<li>${comment.content}</li>`
	// 	})
	// 	content += `</ul>`;
	// 	app.innerHTML = content;
	// })
	// .catch(err => console.log(err));
// // 			<ul> ${songs.comments.map(songs => {return `
// // 				<li> ${song.songTitle} </li> `;
// // 				})
// // 				}.join("")}
// // 				</ul>
// //     		songs[0].comments.forEach(comment => {
//     		// commentsContent += `<li>${comment.content}</li>`
// 		})
// 		content += `</ul>`;
// 		app.innerHTML = content;
// 	})
// 	.catch(err => console.log(err));



	fetch("/songs")
	.then(response => response.json())
	.then(songs => {

	  
	  let content = `<ul>`; 
	  console.log(songs);

	  songs.forEach(song => {
		content += `
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
	  content += `</ul>`;
	  let commentsContent = '<ul>';

	  songs[0].comments.forEach(comment => {
		  commentsContent += `<li>${comment.commentContent}</li>`

	  })
	  commentsContent += '</ul>'
	  app.innerHTML = commentsContent;
	})
	.catch(err => console.log(err));
    


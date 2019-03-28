export default function Genres(genres){
    return `
    ${genres.map(genre =>{
       return `
                <h3 class="genre__genreName" id="${genre.id}"> ${genre.genreName} </h3>
        `
    }).join('')}

    `
}
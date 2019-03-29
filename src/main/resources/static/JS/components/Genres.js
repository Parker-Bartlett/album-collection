export default function Genres(genres){
    return `
    ${genres.map(genre =>{
       return `
                <h4 class="genre__genreName" id="${genre.id}"> ${genre.genreName} </h4>
        `
    }).join('')}

    `
}
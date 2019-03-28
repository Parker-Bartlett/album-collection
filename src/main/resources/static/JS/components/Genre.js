import Artist from './Artist'
export default function Genre(genre){
   return `
   <h2 class="genre__genreName">${genre.genreName}</h2>
        <ul class="genre__artists">
        ${genre.artists.map(artist => {
            return `
                <li class="artist">
                    <h3 class="artist__artistName" id="${artist.id}">${artist.artistName}</h3>                     
                </li>
                    `
        }).join('')}
        </ul>
    `
}

import Albums from './Albums'
import Genres from './Genres'

export default function Artist(artist) {
    return `
        <h3 class="artist__artistName">${artist.artistName}</h3>
        <p class="artist__image">${artist.image}</p>
 
        <ul class="albums">
            <li class="album">${Albums(artist.albums)}</li>
        </ul>

        <ul class="genres">
            <li class="genre">${Genres(artist.genres)}</li>
        </ul>

        <section class="add__album">
            <input type="text" class="add__albumTitle" placeholder="Album Title">
            <input type="text" class="add__image" placeholder="Image URL">
            <button class="add__album__button" id="${artist.id}">Add Album</button>
        </section>

        <section class="add__genre">
            <input type="text" class="add__genreName" placeholder="Genre">
            <button class="add__genre__button" id="${artist.id}">Submit</button>
        </section>

            `
}       
import Albums from './Albums'

export default function Artist(artist) {
    return `
        <h3 class="artist__artistName">${artist.artistName}</h3>
        <p class="artist__image">${artist.image}</p>
 
        <ul class="albums">
            <li class="album">${Albums(artist.albums)}</li>
        </ul>
            `
}
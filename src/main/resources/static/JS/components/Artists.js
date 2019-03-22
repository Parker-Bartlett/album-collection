export default function Artists(artists) {
    return `
        <ul class="aritsts">
            ${artists.map(artist => {
                return `
                    <li class="artist">
                        <h3 class="artist__artistName">${artist.artistName}</h3>
                        <p class="artist__image">${artist.image}</p>
                    </li>
                    `
            }).join('')}
        </ul>
        `
}
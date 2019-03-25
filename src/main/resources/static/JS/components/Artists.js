export default function Artists(artists) {
    return `
        <ul class="artists">
            ${artists.map(artist => {
                return `
                    <li class="artist">
                        <h3 class="artist__artistName">${artist.artistName}</h3>                     
                    </li>
                    `
            }).join('')}
        </ul>
        `
}
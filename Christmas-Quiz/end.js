const username = document.querySelector('#username')
const saveScoreBtn = document.querySelector('#saveScore')
const finalScore = document.querySelector('#finalScore')
const mostRecentScore = localStorage.getItem('mostRecentScore')

const highScores = JSON.parse(localStorage.getItem('highScores')) || []

const MAX_HIGH_SCORES = 8

const MAX_QUESTIONS = 20

const percent = Math.floor(((mostRecentScore/100)/MAX_QUESTIONS)*100)


finalScore.innerText = `${mostRecentScore}/${percent}%`



username.addEventListener('keyup', () => {
    saveScoreBtn.disabled = !username.value
})

saveHighScore = e => {
    e.preventDefault()

    const score = {
        score: mostRecentScore,
        name: username.value
    }

    highScores.push(score)

    highScores.sort((a,b) => {
        return b.score - a.score
    })

    highScores.splice(5)

    localStorage.setItem('highScores', JSON.stringify(highScores))
    window.location.assign('/')

    
}
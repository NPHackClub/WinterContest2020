const question = document.querySelector('#question');
const choices = Array.from(document.querySelectorAll('.choice-text'));
const progressText = document.querySelector('#progressText');
const scoreText = document.querySelector('#score');
const progressBarFull = document.querySelector('#progressBarFull');

let currentQuestion = {}
let acceptingAnswers = true
let score = 0
let questionCounter = 0
let availableQuestions = []

let questions = [{
	question: 'What did the other reindeer not let Rudolph do because of his shiny red nose?',
	choice1: 'Talk to them',
	choice2: 'Join in any games',
	choice3: 'Fly With Them',
	choice4: 'Eat Lunch With Them',
	answer: 2,
}, {
	question: 'Who Plays Kevin McCallister In The Home Alone Movies?',
	choice1: 'Kieran Culkin',
	choice2: "Henry Thomas",
	choice3: 'Macaulay Culkin',
	choice4: 'Joseph Gordon-Levitt',
	answer: 3,
}, {
	question: " What is Frosty the Snowman's nose made of?",
	choice1: "A Carrot",
	choice2: "A Rock",
	choice3: "A Potato",
	choice4: "A Button",
	answer: 4,
}, {
	question: 'What Colour Is The Grinch?',
	choice1: 'Green',
	choice2: 'Blue',
	choice3: 'Red',
	choice4: "Yellow",
	answer: 1,
},
{
	question: 'What do people traditionally put on top of a Christmas tree?',
	choice1: 'A Star',
	choice2: "An Angel",
	choice3: 'A Light',
	choice4: 'An Elf',
	answer: 2,
},
{
	question: 'In Home Alone, where are the McCallisters going on vacation?',
	choice1: 'Cuba',
	choice2: "Toronto",
	choice3: 'London',
	choice4: 'Paris',
	answer: 4,
},{
	question: 'What is the name of the Elf from Elf?',
	choice1: 'Buddy',
	choice2: 'Randy',
	choice3: 'Rocky',
	choice4: 'Elfy',
	answer: 1,
},{
	question: 'Which country started the tradition of putting up a tree?',
	choice1: 'Canada',
	choice2: 'USA',
	choice3: 'Russia',
	choice4: 'Germany',
	answer: 4,
},{
	question: ' Three of Santa’s reindeer’s names begin with the letter “D.” What are those names?',
	choice1: 'Dancer, Dasher, Dante',
	choice2: 'Dancer, Dasher, Donny',
	choice3: 'Dancer, Dasher, and Donner',
	choice4: 'Dancer, Donner, Donny',
	answer: 3,
}
,{
	question: 'What was the first company that used Santa Claus in advertising?',
	choice1: 'Coca-Cola',
	choice2: 'Pepsi',
	choice3: 'McDonalds',
	choice4: 'Chic-Fil-A',
	answer: 1,
},{
	question: 'In the movie Elf, how does Buddy get to the North Pole?',
	choice1: 'Sneaks On To The Sleigh',
	choice2: 'Kidnapped By A Elf',
	choice3: 'Hides In Santa’s Bag',
	choice4: 'He Was Born In The North Pole',
	answer: 3,
},{
	question: 'In “Frosty the Snowman,” what made Frosty come to life?',
	choice1: 'A Hat',
	choice2: 'A Scarf',
	choice3: 'A nose',
	choice4: 'A Pipe',
	answer: 1,
},{
	question: 'What Christmas beverage is also known as “milk punch?”',
	choice1: 'Christmas Spirit Drink',
	choice2: 'Eggnog',
	choice3: 'Hot Chocolate',
	choice4: 'Christmas Punch',
	answer: 2,
},{
	question: 'In Home Alone 2, who does Kevin run into in the hotel lobby?”',
	choice1: 'Mark Wahlberg',
	choice2: 'Dave Matthews',
	choice3: 'Donald Trump',
	choice4: 'Jeff Gordon',
	answer: 3,
},{
	question: 'In the episode of Friends ‘The One with the Holiday Armadillo’, who dresses up as an armadillo?',
	choice1: 'Chandler',
	choice2: 'Joey',
	choice3: 'Gunther',
	choice4: 'Ross',
	answer: 4,
},{
	question: 'What year did Mariah Carey’s ‘All I Want For Christmas Is You’ come out?',
	choice1: '1993',
	choice2: '1994',
	choice3: '1995',
	choice4: '1999',
	answer: 2,
},{
	question: 'Which country did eggnog originate?',
	choice1: 'USA',
	choice2: 'Canada',
	choice3: 'Germany',
	choice4: 'Britain',
	answer: 4,
},{
	question: 'In which country is it tradition to eat KFC for Christmas dinner?',
	choice1: 'Japan',
	choice2: 'China',
	choice3: 'Thailand',
	choice4: 'India',
	answer: 1,
},{
	question: 'In Elf, what’s the first rule in the Code of The Elves?',
	choice1: 'Theres room for everybody on the nice list',
	choice2: 'Treat every day like Christmas',
	choice3: 'The best way to spread christmas cheer is to sing loud for all to hear',
	choice4: 'There are no code of elves',
	answer: 2,
},{
	question: 'According to tradition, when should you have your Christmas decorations down by?',
	choice1: 'Dec 26',
	choice2: 'Jan 1',
	choice3: 'Jan 5',
	choice4: 'Dec 28',
	answer: 3,
}]

const SCORE_POINTS = 100
const MAX_QUESTIONS = 20

startGame = () => {
    questionCounter = 0
    score = 0
    availableQuestions = [...questions]
    getNewQuestion()
}

getNewQuestion = () => {
    if(availableQuestions.length === 0 || questionCounter > MAX_QUESTIONS) {
        localStorage.setItem('mostRecentScore', score)

        return window.location.assign('/end.html')
    }

    questionCounter++
    progressText.innerText = `Question ${questionCounter} of ${MAX_QUESTIONS}`
    progressBarFull.style.width = `${(questionCounter/MAX_QUESTIONS) * 100}%`
    
    const questionsIndex = Math.floor(Math.random() * availableQuestions.length)
    currentQuestion = availableQuestions[questionsIndex]
    question.innerText = currentQuestion.question

    choices.forEach(choice => {
        const number = choice.dataset['number']
        choice.innerText = currentQuestion['choice' + number]
    })

    availableQuestions.splice(questionsIndex, 1)

    acceptingAnswers = true
}

choices.forEach(choice => {
    choice.addEventListener('click', e => {
        if(!acceptingAnswers) return

        acceptingAnswers = false
        const selectedChoice = e.target
        const selectedAnswer = selectedChoice.dataset['number']

        let classToApply = selectedAnswer == currentQuestion.answer ? 'correct' : 'incorrect'

        if(classToApply === 'correct') {
            incrementScore(SCORE_POINTS)
        }

        selectedChoice.parentElement.classList.add(classToApply)

        setTimeout(() => {
            selectedChoice.parentElement.classList.remove(classToApply)
            getNewQuestion()

        }, 1000)
    })
})

incrementScore = num => {
    score +=num
    scoreText.innerText = score
}

startGame()
var notyf = new Notyf();

const formContainer = document.getElementById('form-container')
const notesContainer = document.getElementById('notes-container')
const myForm = document.getElementById('my-form')
const editForm = document.getElementById('edit-form')
const editTitle = document.getElementById('edit-title')
const editDescription = document.getElementById('edit-description')
const menuIcon = document.getElementById('menu-icon')
const allNotes = document.getElementById('all-notes')
const input = document.getElementById('input')
const notes = JSON.parse(localStorage.getItem('notes')) || []

let editIndex;

const displayHome = () =>{
    formContainer.style.display="block"
    allNotes.style.display="none"
}
const displayNotes = () =>{
    formContainer.style.display="none"
    allNotes.style.display="block"
}

myForm.addEventListener('submit',(e)=>{
    e.preventDefault()
    
    let note = {

        title:e.target.title.value,
        description:e.target.description.value
    }
    myForm.reset()
    addNote(note)

})

const addNote = (note)  => {
    notes.push(note)
    notyf.success('Note Added!');
    updateLs()  
}

const editNote = (index) => {
    editTitle.value=notes[index].title
    editDescription.value=notes[index].description
    editIndex = index
}


const fetchNotes = () => {
    notesContainer.innerHTML = ""
    if(notes.length==0){
        notesContainer.innerHTML = `<p class="fs-5 text-center">Nothing to display !!</p>`
        return
    }
    notes.forEach((note,index)=>{
        let noteBox = document.createElement('div')
        noteBox.classList.add('card')
        noteBox.innerHTML = `
        <h2 class="card-title">${note.title}</h2>
        
        <p>${note.description}</p>
        <div class="d-flex gap-2">
            <button class="btn btn-danger"><i class="fa-solid fa-trash"></i> </button>
            <button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-edit"></i> </button>
        </div>
        
        
        `
        notesContainer.appendChild(noteBox)

        noteBox.querySelector('.btn-danger').addEventListener('click',()=>{
            notes.splice(index,1)
          updateLs()
            notyf.success('Note deleted!');
        })
        noteBox.querySelector('.btn-warning').addEventListener('click',()=>{
            editNote(index)
        })
    })
}

editForm.addEventListener('submit',(e)=>{
    e.preventDefault()
    notes[editIndex].title=editTitle.value
    notes[editIndex].description=editDescription.value
    editForm.reset() 
    notyf.success('Note saved!');
   updateLs()

})

fetchNotes()

const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')

if (toastTrigger) {
  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
  toastTrigger.addEventListener('click', () => {
    toastBootstrap.show()
  })
}

function toggleMenu(){
  if(menuIcon.classList.contains('fa-bars')){
    menuIcon.classList.replace('fa-bars','fa-xmark')
  }else{
    menuIcon.classList.replace('fa-xmark','fa-bars')
  }
}

function updateLs(){
    localStorage.setItem('notes',JSON.stringify(notes))
    fetchNotes()
}

input.addEventListener('keyup',(e)=>{
   let searchTerm = e.target.value.toUpperCase()

   notesContainer.querySelectorAll('.card-title').forEach((title)=>{
        if(title.textContent.toUpperCase().includes(searchTerm)){
            title.parentElement.style.display=""
        }else{
            title.parentElement.style.display="none"
        }
   })
   
})


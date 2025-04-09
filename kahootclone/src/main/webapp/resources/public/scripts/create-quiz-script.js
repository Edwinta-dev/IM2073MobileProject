let questionCount = 1; // Initial question number

// Function to create a new question and its options
function addQuestion() {
  // Create new question div
  const questionDiv = document.createElement("div");
  questionDiv.classList.add("question");
  questionDiv.id = `question-${questionCount}`;

  // Create question input field
  const questionElementsDiv = document.createElement("div");
  questionElementsDiv.classList.add("container");

  const questionInputDiv = document.createElement("div");
  questionInputDiv.classList.add("elements");
  const questionLabel = document.createElement("label");
  questionLabel.setAttribute("for", `question${questionCount}`);
  questionLabel.innerText = `Question ${questionCount}:`;
  questionLabel.style.fontWeight = "bold";
  const questionInput = document.createElement("input");
  questionInput.type = "text";
  questionInput.id = `question${questionCount}`;
  questionInput.name = `questions[${questionCount}]`;
  questionInput.required = true;
  questionInputDiv.appendChild(questionLabel);
  questionInputDiv.appendChild(questionInput);
  questionElementsDiv.appendChild(questionInputDiv);

  // Add "Done?" switch
  const doneSwitchDiv = document.createElement("div");
  doneSwitchDiv.classList.add("elements");
  const formCheckDiv = document.createElement("div");
  formCheckDiv.classList.add("form-check", "form-switch");

  const hiddenInput = document.createElement("input");
  hiddenInput.type = "hidden";
  hiddenInput.name = `switch${questionCount}`;
  hiddenInput.value = "false";

  const checkboxInput = document.createElement("input");
  checkboxInput.classList.add("form-check-input");
  checkboxInput.type = "checkbox";
  checkboxInput.role = "switch";
  checkboxInput.id = `switchCheck${questionCount}`;
  checkboxInput.name = `question-${questionCount}_completed`;
  checkboxInput.value = "true";
//  checkboxInput.addEventListener("change",()=>);
  const checkboxLabel = document.createElement("label");
  checkboxLabel.classList.add("form-check-label");
  checkboxLabel.setAttribute("for", `switchCheck${questionCount}`);
  checkboxLabel.innerText = "Done?";

  formCheckDiv.appendChild(hiddenInput);
  formCheckDiv.appendChild(checkboxInput);
  formCheckDiv.appendChild(checkboxLabel);
  doneSwitchDiv.appendChild(formCheckDiv);
  questionElementsDiv.appendChild(doneSwitchDiv);

  // Append question elements to the question div
  questionDiv.appendChild(questionElementsDiv);

  // Options container
  const optionsDiv = document.createElement("div");
  optionsDiv.classList.add("options");

  // Add first option
  addOption(optionsDiv, questionCount);

  // Add "Add Option" button
  const addOptionButton = document.createElement("button");
  addOptionButton.type = "button";
  addOptionButton.classList.add("btn", "btn-secondary");
  addOptionButton.innerText = "Add Option";
  addOptionButton.addEventListener("click", () =>
    addOption(optionsDiv, questionCount)
  );

  // Append the options and button to the question
  questionElementsDiv.appendChild(addOptionButton);
  questionDiv.appendChild(optionsDiv);

  // Append the new question to the questions container
  document.getElementById("questionsContainer").appendChild(questionDiv);

  // Increment question count for next question
  questionCount++;
}

// Function to add options inside a question
function addOption(optionsDiv, questionNumber) {
  const optionCount = optionsDiv.children.length + 1; // Ensure correct option number

  const optionDiv = document.createElement("div");
  optionDiv.classList.add("container", "mt-2");

  const optionInputDiv = document.createElement("div");
  optionInputDiv.classList.add("element");
  const optionLabel = document.createElement("label");
  optionLabel.setAttribute(
    "for",
    `option${questionNumber}-${optionCount}`
  );
  optionLabel.innerText = `Option ${optionCount}:`;

  const optionInput = document.createElement("input");
  optionInput.type = "text";
  optionInput.id = `option${questionNumber}-${optionCount}`;
  optionInput.name = `options[${questionNumber}][${optionCount}]`;
  optionInput.required = true;

  optionInputDiv.appendChild(optionLabel);
  optionInputDiv.appendChild(optionInput);
  optionDiv.appendChild(optionInputDiv);

  // Add "Correct?" switch for each option
  const correctSwitchDiv = document.createElement("div");
  correctSwitchDiv.classList.add("elements");
  const formCheckDiv = document.createElement("div");
  formCheckDiv.classList.add("form-check", "form-switch");

  const hiddenInput = document.createElement("input");
  hiddenInput.type = "hidden";
  hiddenInput.name = `switch${questionNumber}`;
  hiddenInput.value = "false";

  const checkboxInput = document.createElement("input");
  checkboxInput.classList.add("form-check-input");
  checkboxInput.type = "checkbox";
  checkboxInput.role = "switch";
  checkboxInput.id = `switchCheckOption${questionNumber}-${optionCount}`;
  checkboxInput.name = `option-${questionNumber}-${optionCount}_correct`;
  checkboxInput.value = "true";

  const checkboxLabel = document.createElement("label");
  checkboxLabel.classList.add("form-check-label");
  checkboxLabel.setAttribute(
    "for",
    `switchCheckOption${questionNumber}-${optionCount}`
  );
  checkboxLabel.innerText = "Correct?";

  formCheckDiv.appendChild(hiddenInput);
  formCheckDiv.appendChild(checkboxInput);
  formCheckDiv.appendChild(checkboxLabel);
  correctSwitchDiv.appendChild(formCheckDiv);
  optionDiv.appendChild(correctSwitchDiv);

  optionsDiv.appendChild(optionDiv);
}


// Event listener to add the first question when the page loads
document.addEventListener("DOMContentLoaded", () => {
  addQuestion(); // Automatically add the first question
});

// Event listener for the "Add Question" button
document
  .getElementById("addQuestionButton")
  .addEventListener("click", addQuestion);

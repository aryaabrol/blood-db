from chatterbot import ChatBot
chatbot = ChatBot("Vishwajeet")

from chatterbot.trainers import ListTrainer

conversation = [
    "Hello",
    "Hi there!",
    "How are you doing?",
    "I'm doing great.",
    "That is good to hear",
    "Thank you.",
    "You're welcome.",
    "Bye",
    "Will it hurt when you insert the needle?",
    "Only for a moment. Pinch the fleshy, soft underside of your arm. That pinch is similar to what you will feel when the needle is inserted.",
    "Is blood donation safe?",
    "Yes, blood donation is considered very safe. Sterile, disposable medical equipment is used for each donor, which negates risk of bloodborne infection.",
    "How long does it take to give blood?",
    "The entire blood donation process takes about 45 minutes, while the blood-drawing procedure itself takes about 10 minutes.",
    "Where can I donate blood?",
    "Register with us to get locations of nearest blood banks",
    "How does blood donation process work?",
    "Donating blood is a simple thing to do, but can make a big difference in the lives of others. The donation process from the time you arrive until the time you leave takes about an hour. The donation itself is only about 8-10 minutes on average.",
    "What should I do after donating blood?",
    "Drink an extra four glasses eight ounces each of non-alcoholic liquids.",
    "What happens to blood I donate?",
    "Your blood in the blood bank is processed and within 6 hours of Blood collection It  is separated into components viz. Red Cells, White Cells, Plasma & Platelets. These Blood components are made available for the patients. By making blood components, all the useful parts of blood can be used and from one unit of blood four patients can be benefited"
]

trainer = ListTrainer(chatbot)

trainer.train(conversation)
print('SAY SOMETHING!')
while(1==1):
    x = input()
    response = chatbot.get_response(x)
    print(response)



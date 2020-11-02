from chatterbot import ChatBot
chatbot = ChatBot("Vishwajeet",language='FRE')

from chatterbot.trainers import ListTrainer

conversation = [
    
    "Bonjour",
    "Salut!",
    "Comment allez vous?",
    "Je le fais bien.",
    "C'est bon à entendre",
    "Je vous remercie.",
    "De rien.",
    "Au revoir",
    "Cela vous fera-t-il mal lorsque vous insérez l'aiguille?",
    "Seulement pour un instant. Pincez le dessous charnu et doux de votre bras. Ce pincement est similaire à ce que vous ressentirez lorsque l'aiguille est insérée.",
    "Le don de sang est-il sûr?",
    "Oui, le don de sang est considéré comme très sûr. Un équipement médical stérile et jetable est utilisé pour chaque donneur, ce qui élimine le risque d'infection transmissible par le sang.",
    "Combien de temps faut-il pour donner du sang?",
    "L'ensemble du processus de don de sang prend environ 45 minutes, tandis que la procédure de prélèvement de sang elle-même prend environ 10 minutes.",
    "Où puis-je donner du sang?",
    "Inscrivez-vous avec nous pour connaître les emplacements des banques de sang les plus proches",
    "Comment fonctionne le processus de don de sang?",
    "Le don de sang est une chose simple à faire, mais peut faire une grande différence dans la vie des autres. Le processus de don entre le moment où vous arrivez et celui où vous partez prend environ une heure. Le don lui-même ne dure que 8 à 10 minutes en moyenne.",
    "Que dois-je faire après avoir donné du sang?",
    "Buvez quatre verres supplémentaires de huit onces chacun de liquides non alcoolisés.",
    "Qu'arrive-t-il au sang que je donne?",
    "Votre sang dans la banque de sang est traité et dans les 6 heures suivant le prélèvement sanguin Il est séparé en composants à savoir. Globules rouges, globules blancs, plasma et plaquettes. Ces composants sanguins sont mis à la disposition des patients. En fabriquant des composants sanguins, tous les des parties utiles de sang peuvent être utilisées et à partir d’une unité de sang, quatre patients peuvent en bénéficier "
]

trainer = ListTrainer(chatbot)

trainer.train(conversation)
print('SAY SOMETHING!')
while(1==1):
    x = input()
    response = chatbot.get_response(x)
    print(response)



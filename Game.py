import time
import random


def print_pause(message_to_print):
    print(message_to_print)
    time.sleep(1.8)


def intro():
    print_pause("You are born in an era where "
                "the evil demon 'Xi Gong Di' reigns.")
    print_pause("Fed up by all the injustice, "
                "you seek to find the only weapon to defeat the demon.")
    print_pause("The weapon forged from the powers of Light and Dark.")
    print_pause("You embark on your journey with only "
                "a piece of bread and the clothes on your back.")
    print_pause("You go out of your house and see "
                "the familiar slum that you grew up in.")


def main_choice(items):
    print_pause("What do you want to do next? Please enter number:")
    choice = input("1. Go to Chinvao region\n"
                   "2. Go to the Imperial Capital\n")
    if choice == '1':
        fight_intro(items)
    elif choice == '2':
        capital_intro(items)
    else:
        main_choice(items)


def fight_intro(items):
    your_health = 100
    demon_health = 100
    print_pause("You travel all the way to Chinvao region.")
    print_pause("This is the demon's home town!")
    print_pause("The demon 'Xi Gong Di' sees you!")
    print_pause("'Xi Gong Di' lunges at you! "
                "His sharp rotten teeth bared to bite!")
    fight_choice(items, demon_health, your_health)


def fight_choice(items, demon_health, your_health):
    fight = input("What will you do? Please enter number:\n"
                  "1. Fight!\n"
                  "2. Escape!\n")
    if fight == '1':
        fight_seq1(items, demon_health, your_health)
    elif fight == '2':
        escape(items)
    else:
        fight_choice(items, demon_health, your_health)


def fight_seq1(items, demon_health, your_health):
    demon_damage = round(random.randint(0, 50), -1)
    your_damage = round(random.randint(0, 50), -1)
    if 'Chaos Breaker' in items:
        your_damage = your_damage + 25
        demon_damage = demon_damage / 5
        print_pause("You wield the mighty Chaos Breaker!")
        fight_seq2(items, demon_damage, your_damage, your_health, demon_health)
    elif 'Chaos Breaker' not in items:
        your_damage = your_damage/10
        print_pause("You're fighting a demon using a piece of bread!")
        fight_seq2(items, demon_damage, your_damage, your_health, demon_health)


def fight_seq2(items, demon_damage, your_damage, your_health, demon_health):
    print_pause(f"You inflict {your_damage} damage!")
    demon_health -= your_damage
    print(f"The demon's health is {demon_health}/100")
    if demon_health < 0:
        print_pause("You have successfully slain Xi Gong Di!!")
        print_pause("Finally, the people are free from his tyranny!")
        print_pause("Peace has finally returned to your land.")
        print_pause("Thank you for playing!")
        play_again()
    elif your_health > 0:
        print_pause("The demon Xi Gong Di attacks you!")
        print_pause(f"He inflicts {demon_damage} damage to you!")
        your_health -= demon_damage
        print(f"Your health is {your_health}/100")
        if your_health <= 0:
            print_pause("You have been slain by the Xi Gong Di!")
            print_pause("Evil has continued to ravage the lands.")
            print_pause("GAME OVER!")
            play_again()
        else:
            fight_choice(items, demon_health, your_health)


def escape(items):
    print_pause("You ran as fast as you can!")
    print_pause("You barely escaped with your life!")
    main_choice(items)


def play_again():
    print_pause("Do you want to play again? Please enter number:")
    again = input("1. Yes\n"
                  "2. No\n")
    if again == '1':
        game()
    elif again == '2':
        print_pause("Okay. See you again!")
    else:
        play_again()


def capital_intro(items):
    print_pause("You journey to the Imperial Capital.")
    print_pause("Tall structures rise, but behind this facade "
                "of progress and luxury, evil and corruption exists.")
    if 'bread' in items:
        print_pause("At the corner, you caught the gaze of an old man.")
        print_pause("The old man hesitates at "
                    "first but approaches you anyway.")
        encounter_man(items)
    else:
        print_pause("You tried to search for the old man again.")
        print_pause("He is nowhere to be seen!")
        main_choice(items)


def encounter_man(items):
    print_pause("What will you do? Please enter number:")
    action = input("1. Talk to the man\n"
                   "2. Ignore him\n")
    if action == '1':
        print_pause("'Can you spare me some food?' "
                    "the old man said.")
        print_pause("You only have a piece of bread with you "
                    "and nothing else.")
        food_choice(items)
    elif action == '2':
        ignore_man(items)
    else:
        encounter_man(items)


def food_choice(items):
    print_pause("Will you give the old man your food? Please enter number:")
    give_food = input("1. Give food\n"
                      "2. Continue wandering\n")
    if give_food == '1':
        receive_weapon(items)
    elif give_food == '2':
        ignore_man(items)
    else:
        food_choice(items)


def receive_weapon(items):
    print_pause("You gave your bread to the man.")
    items.remove("bread")
    print_pause("'Thank you kind stranger!' said the old man.")
    print_pause("'Despite not having enough for yourself, "
                "you still gave your food to me'")
    print_pause("'Truly, you have a good heart. You may be our only hope.'")
    print_pause("'Please take this and defeat the demon "
                "that has corrupted our land.'")
    print_pause("You have gained the legendary weapon! The Chaos Breaker!")
    items.append("Chaos Breaker")
    main_choice(items)


def ignore_man(items):
    print_pause("You averted your gaze from the old man "
                "and continued wandering.")
    print_pause("Yet, you feel that there is something about the old man.")
    main_choice(items)


def game():
    items = ["bread"]
    demon_health = 100
    your_health = 100
    intro()
    main_choice(items)


if __name__ == "__main__":
    game()

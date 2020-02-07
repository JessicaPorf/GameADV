package com.qa.Adv;
	import java.util.Random;
	import java.util.Scanner;

public class GameAdv {




	public static void main(String[] args) {
	//System objects
	Scanner in = new Scanner(System.in);
	Random rand = new Random();
	        //Game variables
	String[] enemies = {"Elf", "Evil villager", "Orc", "Witch" };
	int maxEnemyHealth = 100;
	int enemyAttackDamage = 25;
	//Player variables
	int health = 100;
	int attackDamage = 50;
	int numHealthPotions = 3;
	int healthPotionHealAmmount = 30; //Percentage
	
	
	boolean running = true;
	
	System.out.println("Welcome to the fight zone!");

	GAME:
	while(running) {
		System.out.println("-------------------------------");	
		
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + "Hath come fourth! #\n ");
		
			while (enemyHealth > 0) {
				System.out.println("\tYour HP:  " + health);
				System.out.println("\t " + enemy + "'s HP:  " + enemyHealth );	
				System.out.println("\n\tWhat would you like to do?");	
				System.out.println("\t1. Attack");	
				System.out.println("\t2. Drink Health potion");	
				System.out.println("\t3. Run!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the" + enemy + "for" + damageDealt  + "damage.");
					System.out.println("\t> You recieve" + damageTaken + "in retaliation!");
					
					if(health < 1) {
						System.out.println("\t> You have taken to much damage, you're too weak to go on ");
						break;
						
					}
				}
				
				else if(input.equals("2")) {
					 if (numHealthPotions > 0) {
						int healthPotionsHealAmmount = 0;
						health += healthPotionsHealAmmount;
						numHealthPotions--;
						System.out.println("You drink a health potion, healing yourself for" + healthPotionHealAmmount + "." 										
												+ "\n\t> You now have " + health + "HP."
												+"\n\t> You have" + numHealthPotions + " health potions left.\n");
						
					}
					 else {
						 System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n ");
						 
					 }
					 
				
				}	
				if(input.equals("3")) {
					System.out.println("\t You run away from the" + enemy + "!");
					continue GAME; 
				}
				
				else {
					System.out.println("\t Invalid command!");
				}
	}
		
	if(health < 1) {
		System.out.println("You limp out of the dungeon, too weak from battle! ");
		break;
	}
	System.out.println("-------------------------------");	
	System.out.println(" # " + enemy + " was defeated! # ");
	System.out.println("  # You have" + health + "HP left # " );
	int healthPotionDropChance = 0;
	if(rand.nextInt(100) < healthPotionDropChance) {
		numHealthPotions++;
		System.out.println(" # The " + enemy + "dropped a Health Potion! # ");
		System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
		
	}
	System.out.println("-------------------------------");	
	System.out.println("What would you like to do now?");	
	System.out.println("1. Continue fighting");	
	System.out.println("2. Exit the Dungeon");	
	
	String input = in.nextLine();
	
	while(!input.equals("1") && !input.equals("2")) {
		System.out.println("Invalid command!");	
		input = in.nextLine();
	}
	if(input.equals("2")) {
		System.out.println("You exit the Dungeon, success!");
		break;
	}
	}
	System.out.println("####################################");	
	System.out.println("# THANK YOU FOR PLAYING! GAME OVER #");	
	System.out.println("####################################");	
			
			
	
	}
	
	}




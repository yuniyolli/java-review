package com.review1.requestHTML;

public class EntryPointGit {
    public static void main(String[] args) {

        // Define the case of none input not to cause unexpected result
        if (args.length == 0) {
            System.out.println("usage: add, commit");

            // else : to break;
        } else {


            // the first argument is defined as a command
            // except 'commit -m'

            // 1. array without the first argument
            // be aware of how to declare an Array
            int gitIndex = 0;


            // command "add", "commit", "commit -m"
            if (args[0].equals("add")) {
                String[] gits = new String[args.length - 1];
                for (int i = 1; i < args.length; i++) {
                    gits[gitIndex] = args[i];
                    gitIndex++;
                }
                for (String arg : gits) {
                    System.out.println("add changes to git: " + arg);
                }

                // WARN 1: order of 'if'
                // - 'commit' alone should be ahead of 'commit -m' since it cause error about the absence of '-m' before reaching to 'commit' alone.

                // WARN 2: the use of else if
                // - Use 'else if' rather than just 'if' in this cast to prevent keep functioning after getting a result.

                // WARN 3: (OR) Specify your condition
                // - just args[0].equals -> add length < 2
            } else if (args[0].equals("commit") && args.length < 2) {
                System.out.println("no message specified");

            } else if (args[0].equals("commit") && args[1].equals("-m")) {
                //2. array without the first and the second argument
                String[] commits = new String[args.length - 2];
                for (int i = 2; i < args.length; i++) {
                    commits[gitIndex] = args[i];
                    gitIndex++;
                }
                for (String arg : commits) {
                    System.out.println("commit with message: " + arg);
                }


            }
        }
    }
}


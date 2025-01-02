package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P2559 question = new P2559();
		String[] str = {"iudibb","suejjertqtckmzloneax","adwocnu","idwstzyhpmhbasdag","qfsnlums",
				"zokfvsjeualkidcbydbcsdjypacppoueoghpvevp","cddephdgmufwpllzfockd","vqowwarakfflbsmwhzzjedbb",
				"jmlukjrjrlokgypqhqopogrcihlafwuapnctjjj","sjfyacnqqcifisjiciuvqqwkkpfylxuyybgirds","hyfi",
				"gmktyoc","dhvpwwzz","kwjxwvigcukmcbvoeejgdaylrosxira","elxdlsqtarlhpmcwjyv",
				"mloiczxrlxmqyetykoiy","emejlyduwciherxfmohukc","ojhlfmgaalhbvcivtltgkviu",
				"gqrhceguhccfbrnbpmxerfpyvxaw","wmhn","euxnspekzbtqomdpynwreveyekvj",
				"kkfkksflarmaiuzzqoxtwnbbhehgcyehgnyadgls","txjfymocufymepgcmnsxfvldtkoagpadnfsxej",
				"kftsm","hevhskgwskqdztvfviirwrhvdys","vjyfdernzdabdvwrjmundmviwmwdsqjibfrt","c",
				"ufiimkekbmaffinctkexccpbkht","prntvrqrighrajmjxetxnpehllfvsrdhm","d","sbawxagjpqzhkjvfxrmsfbw",
				"zetmyxgyadthxkzpgsycjin","spswgaestqizviowilhgn","zvilwxo",
				"vgegoiydmpkgbpiorwxyupyklrvhdaftbci","udcfeffnwnruzhyffucxxs","gpvavrxaqumtqnivftptnebmmpgtawq",
				"zbraiomlywxufrjxi"};
		int[][] queries = {{21, 25},{21, 25},{7, 30},{22, 24},{17, 28},{25, 26},{20, 24},{24, 32},{18, 26},{22, 27},{36, 36},{7, 13},{30, 31},{20, 27},{16, 30},{10, 23},{13, 30},{33, 37},{29, 31},{31, 36},{8, 23},{30, 35},{32, 37},{2, 15},{10, 12},{20, 32},{31, 34},{33, 36},{2, 22},{9, 14},{16, 36},{10, 28},{10, 37},{29, 30},{22, 29},{34, 37},{20, 24},{37, 37},{33, 33}};

		int[] answer = question.solution(str, queries);
		for(int num : answer) {
			System.out.println(num);
		}
		
	}

}
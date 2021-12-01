package system.scheduler;

import system.MCRB;

public class CreditRefillExceutor extends Scheduler {
	

	public CreditRefillExceutor(String jobName) {
		super(jobName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nSystem: Credit updated");
		MCRB.getInstance().creditRefillAll(300);
	}

	
	
	
}

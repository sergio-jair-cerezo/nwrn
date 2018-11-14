//
//  RNHighScoresResultVC.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/14/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation

class RNHighScoresResultVC: UIViewController {
    
    @IBOutlet weak var resultLabel: UILabel!
    
    var scoresDisplayed: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.title = "Swift"
        
        self.resultLabel.text = "\(scoresDisplayed) scores were displayed"
    }
    
    @IBAction func doneTapped(_ sender: UIButton) {
        self.navigationController?.popToRootViewController(animated: true)
    }
}

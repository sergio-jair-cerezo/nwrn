//
//  SideMenuExternalManager.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/13/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation

@objc(SideMenuExternalManager)
class SideMenuExternalManager: NSObject  {
    
    @objc func openMenuFromJS() -> Void {
        // You won't be on the main thread when called from JavaScript
        DispatchQueue.main.async {
            let appDelegate = UIApplication.shared.delegate as? AppDelegate
            appDelegate?.sideMenuVC.slideMenuController()?.openLeft()
        }
    }
    
    @objc func showHighScoresResultFromJS(_ scoresDisplayed: NSNumber) -> Void {
        DispatchQueue.main.async {
            let appDelegate = UIApplication.shared.delegate as? AppDelegate
            
            let rnHighScoresResultVC = RNHighScoresResultVC(nibName: "RNHighScoresResultVC", bundle: nil) as RNHighScoresResultVC
            rnHighScoresResultVC.scoresDisplayed = scoresDisplayed.intValue
            
            appDelegate?.mainNC.pushViewController(rnHighScoresResultVC, animated: true)
        }
    }
    
    @objc static func requiresMainQueueSetup() -> Bool {
        return false
    }
    
}

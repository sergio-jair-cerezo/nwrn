//
//  SideMenuVC.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/12/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation
import UIKit

class SideMenuVC: UIViewController {
    
    @IBOutlet weak var tableView: UITableView!
    
    var currentMenuOption: MenuOption!
    private var appDelegate: AppDelegate!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.appDelegate = UIApplication.shared.delegate as? AppDelegate
        
        self.tableView.dataSource = self
        self.tableView.delegate = self
    }
    
    enum MenuOption: String {
        case swift = "Swift"
        case react = "React"
        case swiftToRN = "Swift to React"
        case rnToSwift = "React to Swift"
    }
    static let menuOptions: [MenuOption] = [.swift, .react, .swiftToRN, .rnToSwift]
}

extension SideMenuVC: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return SideMenuVC.menuOptions.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: .default, reuseIdentifier: "menu cell")
        cell.textLabel!.text = SideMenuVC.menuOptions[indexPath.row].rawValue
        return cell
    }
}

extension SideMenuVC: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let selectedOption = SideMenuVC.menuOptions[indexPath.row]
        
        if selectedOption == self.currentMenuOption {
            self.slideMenuController()?.closeLeft()
            return
        }
        self.currentMenuOption = selectedOption
        
        switch selectedOption {
        case .swift:
            let swiftFirstVC = SwiftFirstVC(nibName: "SwiftFirstVC", bundle: nil) as SwiftFirstVC
            self.appDelegate.mainNC.setViewControllers([swiftFirstVC], animated: true)
        case .react:
            self.appDelegate.mainNC.setViewControllers([RNEmbededHelper.getRNVC()], animated: true)
        case .swiftToRN:
            let swiftToRNVC = SwiftToRNVC(nibName: "SwiftToRNVC", bundle: nil) as SwiftToRNVC
            self.appDelegate.mainNC.setViewControllers([swiftToRNVC], animated: true)
        default: break;
        }
        
        let hideNavBar = selectedOption == .react
        self.appDelegate.mainNC.setNavigationBarHidden(hideNavBar, animated: false)
        
        self.slideMenuController()?.closeLeft()
    }
}
